const listOfColors = document.getElementById('colors');

listOfColors.addEventListener('click', event => {
    event.target.style.backgroundColor = event.target.innerText;
});

const firstListItem = document.querySelector('li');

firstListItem.addEventListener('click', event => {
	event.stopPropagation();
	//event.target.style.fontSize = '2em';
});

function addOrange() {
	const orange = document.createElement('li');
	orange.innerText = 'Orange';
	colors.appendChild(orange);
}

document.addEventListener('DOMContentLoaded', () => {
	const button = document.getElementById('btnAddOrange');
	button.addEventListener('click', addOrange);
});