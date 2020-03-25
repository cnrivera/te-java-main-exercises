let reviews = [];

function loadReviews() {
  console.log("Loading reviews...");

    return fetch('http://localhost:8080/product-reviews-api/api/reviews')
      .then((response) => {
        if (response.ok) {
          return response.json();       
        } else {
          throw new Error('Response was not okay.');
        }
      })
      .then((data) => {
        reviews = data;
      });
}

let button = document.querySelector('button');
button.addEventListener('click', () => {
  loadReviews()
    .then(displayReviews)
    .catch((err) => {
      console.log('An error occurred: ' + err.message);
    });
});


function deleteReview(reviewId) {
    fetch('http://localhost:8080/product-reviews-api/api/reviews/' + reviewId, {method: 'DELETE'})
    .then(loadReviews)
    .then(displayReviews);
}

/**
 * This function when invoked will look at an array of reviews
 * and add it to the page by cloning the #review-template
 */
function displayReviews() {
    console.log('Display Reviews...');
  
    // first check to make sure the browser supports content templates
    if('content' in document.createElement('template')) {
      // query the document for .reviews and assign it to a variable called container
      const container = document.querySelector('.reviews');

      container.querySelectorAll('.review').forEach((review) => {
        review.remove();
      });


      // loop over the reviews array
      reviews.forEach((review) => {
        // get the template; find all the elements and add the data from our review to each element
        const tmpl = document.getElementById('review-template').content.cloneNode(true);
        tmpl.querySelector('img').setAttribute('src',review.avatar);
        tmpl.querySelector('.username').innerText = review.username;
        tmpl.querySelector('h2').innerText = review.title;
        tmpl.querySelector('.published-date').innerText = review.publishedOn;
        tmpl.querySelector('.user-review').innerText = review.review;

        tmpl.querySelector('button').addEventListener('click', () => {
          deleteReview(review.id);
        });

        container.appendChild(tmpl);
      });
    } else {
      console.error('Your browser does not support templates');
    }
}