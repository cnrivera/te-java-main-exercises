const rabbitsDiv = document.getElementById('rabbits');


rabbitsDiv.addEventListener('click', () => {
    rabbitsDiv.innerText += rabbitsDiv.innerText;
});


const messageInput = document.getElementById('message');

messageInput.addEventListener('keydown', (e) => {
    e.preventDefault();
    console.log(e.key);
});