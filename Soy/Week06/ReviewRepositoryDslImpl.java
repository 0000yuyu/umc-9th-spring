import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    private final QReview review = QReview.review;
    private final QStore store = QStore.store;

    public ReviewRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Page<ReviewDto> findMyReviewsWithFilter(Long userId, ReviewFilterCondition condition, Pageable pageable) {

        List<ReviewDto> content = queryFactory
            .select(Projections.constructor(ReviewDto.class,
                review.id.as("reviewId"),
                store.name.as("storeName"),
                review.score,
                review.content
            ))
            .from(review)
            .join(review.store, store)
            .where(
                review.user.id.eq(userId),
                createWhereCondition(condition)
            )
            .orderBy(review.id.desc())
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize())
            .fetch();

        JPAQuery<Long> countQuery = queryFactory
            .select(review.count())
            .from(review)
            .join(review.store, store)
            .where(
                review.user.id.eq(userId),
                createWhereCondition(condition)
            );

        return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchOne);
    }

    private BooleanBuilder createWhereCondition(ReviewFilterCondition condition) {
        BooleanBuilder builder = new BooleanBuilder();
        
	    if (condition.getStoreName() != null && !condition.getStoreName().isEmpty()) {
            builder.and(store.name.eq(condition.getStoreName()));
        }

        if (condition.getScoreRange() != null) {
            
            int startScore = condition.getScoreRange();
            int endScore = startScore + 1;

            if (startScore == 5) {
                builder.and(review.score.eq(5));
            } 
            else if (startScore >= 1 && startScore < 5) {
                builder.and(review.score.goe(startScore));
                builder.and(review.score.lt(endScore));
            }
        }
        
        return builder;
    }
}
