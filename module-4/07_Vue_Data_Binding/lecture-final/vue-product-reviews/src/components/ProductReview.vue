<template>
    <div class="main">
        <h2>Product Reviews for {{ name }}</h2>

        <p class="description">{{ description }}</p>

        <div class="well-display">
            <div class="well">
                <span class="amount">{{ averageRating }}</span>
                Average Rating
            </div>

            <div class="well">
                <span class="amount">{{ numberOfOneStarReviews }}</span>
                1 Star Review{{ numberOfOneStarReviews === 1? '' : 's' }}
            </div>

            <div class="well">
                <span class="amount">{{ numberOfTwoStarReviews }}</span>
                2 Star Review{{ numberOfTwoStarReviews === 1? '' : 's'}}
            </div>

            <div class="well">
                <span class="amount">{{ numberOfThreeStarReviews }}</span>
                3 Star Review{{ numberOfThreeStarReviews === 1? '' : 's'}}
            </div>

            <div class="well">
                <span class="amount">{{ numberOfFourStarReviews }}</span>
                4 Star Review{{ numberOfFourStarReviews === 1? '' : 's'}}
            </div>

            <div class="well">
                <span class="amount">{{ numberOfFiveStarReviews }}</span>
                5 Star Review{{ numberOfFiveStarReviews === 1? '' : 's'}}
            </div>
        </div>

        <div class="review" v-for="review in reviews" :key="review.id">
            <h4>{{ review.reviewer }}</h4>
            <div class="rating">
                <img src="../assets/star.png" :title="review.rating + ' Star Review'" class="ratingStar" v-for="n in review.rating" v-bind:key="n" />
            </div>
            <h3>{{ review.title }}</h3>

            <p>{{ review.review }}</p>
        </div>
    </div>
</template>

<script>
export default {
    name: "product-review",
    data() {
        return {
            name: 'Cigar Parties for Dummies',
            description: 'Host and plan the perfect cigar party for all of your squirrelly friends.',
            reviews: [
                {
                    id: 1,
                    reviewer: "Malcolm Gladwell",
                    title: 'What a book!',
                    review: "It certainly is a book. I mean, I can see that. Pages kept together with glue (I hope that's glue) and there's writing on it, in some language.",
                    rating: 3
                },
                {
                    id: 2,
                    reviewer: "Tim Ferriss",
                    title: 'Had a cigar party started in less than 4 hours.',
                    review: "It should have been called the four hour cigar party. That's amazing. I have a new idea for muse because of this.",
                    rating: 4
                },
                {
                    id: 3,
                    reviewer: "Ramit Sethi",
                    title: 'What every new entrepreneurs needs. A door stop.',
                    review: "When I sell my courses, I'm always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.",
                    rating: 1
                },
                {
                    id: 4,
                    reviewer: "Gary Vaynerchuk",
                    title: 'And I thought I could write',
                    review: "There are a lot of good, solid tips in this book. I don't want to ruin it, but prelighting all the cigars is worth the price of admission alone.",
                    rating: 3
                }
            ]
        };
    },
    computed: {
        averageRating() {
            if (this.reviews.length > 0) {
                let sum = this.reviews.reduce((totalSoFar, review) => {
                    return totalSoFar + review.rating;
                }, 0);

                return sum / this.reviews.length;
            } else {
                return 0;
            }
        },
        numberOfOneStarReviews() {
            return this.numberOfReviewsForRating(1);
        },
        numberOfTwoStarReviews() {
            return this.numberOfReviewsForRating(2);
        },
        numberOfThreeStarReviews() {
            return this.numberOfReviewsForRating(3);
        },
        numberOfFourStarReviews() {
            return this.numberOfReviewsForRating(4);
        },
        numberOfFiveStarReviews() {
            return this.numberOfReviewsForRating(5);
        }
    },
    methods: {
        numberOfReviewsForRating(rating) {
            let count = this.reviews.reduce((countSoFar, review) => {
                if (review.rating === rating) {
                    countSoFar++;
                }
                return countSoFar;
            }, 0);

            return count;
        }
    }
}
</script>

<style scoped>
    div.main {
        margin: 1rem 0;
    }

    div.main div.well-display {
        display: flex;
        justify-content: space-around;
    }

    div.main div.well-display div.well {
        display: inline-block;
        width: 15%;
        border: 1px black solid;
        border-radius: 6px;
        text-align: center;
        margin: 0.25rem;
    }

    div.main div.well-display div.well span.amount {
        color: darkslategray;
        display: block;
        font-size: 2.5rem;
    }

    div.main div.review {
        border: 1px black solid;
        border-radius: 6px;
        padding: 1rem;
        margin: 10px;
    }

    div.main div.review div.rating {
        height: 2rem;
        display: inline-block;
        vertical-align: top;
        margin: 0 0.5rem;
    }

    div.main div.review div.rating img {
        height: 100%;
    }

    div.main div.review p {
        margin: 20px;
    }

    div.main h3 {
        display: inline-block;
    }

    div.main h4 {
        font-size: 1rem;
    }
</style>