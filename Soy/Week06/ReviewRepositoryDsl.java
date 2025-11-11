public interface ReviewRepositoryCustom {
    Page<ReviewDto> findMyReviewsWithFilter(Long userId, ReviewFilterCondition condition, Pageable pageable);
}

public class ReviewFilterCondition {
    private String storeName;
    private Integer scoreRange;
}
