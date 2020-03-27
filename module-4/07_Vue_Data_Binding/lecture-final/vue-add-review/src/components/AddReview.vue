<template>
  <div class="container">
    <h1>Add New Review</h1>
    <div class="row">
      <div class="col-7">
        <form>
          <div class="form-group">
            <label for="title">Title</label>
            <input type="text" class="form-control" id="title" placeholder="Enter title" v-model.trim.lazy="review.title">
          </div>
          <div class="form-group">
            <label for="reviewer">Reviewer</label>
            <input type="text" class="form-control" id="reviewer" placeholder="Enter reviewer's name" v-model.lazy="review.reviewer">
          </div>
          <div class="form-group">
            <label for="rating">Rating</label>
            <select class="form-control" id="rating" v-model.number="review.rating">
              <option>1</option>
              <option>2</option>
              <option>3</option>
              <option>4</option>
              <option>5</option>
            </select>
          </div>
          <div class="form-group">
            <label for="review">Review</label>
            <textarea class="form-control" id="review" rows="3" v-model="review.review"></textarea>
          </div>
          <div class="form-group">
            <div><input type="checkbox" value="Happy" v-model="review.mood"/><label>Happy</label></div>
            <div><input type="checkbox" value="Sad" v-model="review.mood"/><label>Sad</label></div>
            <div><input type="checkbox" value="Worried" v-model="review.mood"/><label>Worried</label></div>
            <div><input type="checkbox" value="Excited" v-model="review.mood"/><label>Excited</label></div>
          </div>


          <button type="submit" class="btn btn-primary">Save Review</button>
        </form>
      </div>
      <div class="col-5">
        <h2>Submission</h2>
        <hr>
        <p>Title: {{ review.title }}</p>
        <p>Reviewer: {{ review.reviewer }}</p>
        <p>Rating: {{ review.rating }} </p>
        <p>Review: {{ review.review }} </p>
        <p>Mood: {{ review.mood.join(' and ')}}</p>
        <p style="font-size: 3em" v-if="review.mood.includes('Happy')">😁</p>
        <p style="font-size: 3em" v-show="review.mood.includes('Sad')">😢</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      review: {
        title: '',
        reviewer: '',
        rating: '',
        review: '',
        mood: []
      }
      
    }
  }
}
</script>

<style>
h1 { 
  margin-top: 20px;
}


</style>
