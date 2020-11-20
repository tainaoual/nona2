import{
    displaySingleAlbum,
    clearChildren
}from "./displaySingleAlbum.js"

import {
    deleteAlbum
} from "./deleteAlbum.js"

const displayHomeView = function(Album){

    const mainElement = document.createElement("main");
    mainElement.classList.add("main")
    
    const columnMainElement = document.createElement("section");
    columnMainElement.classList.add("column-main")
    
    // const headerAlbums = document.createElement('div')
    // headerAlbums.classList.add("header albums")
    columnMainElement.innerHTML = `
    <div class="header albums">
            <h1>Albums</h1>
    </div>`
    const allCardElement = document.createElement("div");
    allCardElement.classList.add("all-cards")

    mainElement.appendChild(columnMainElement);
    // mainElement.appendChild(headerAlbums);
    columnMainElement.appendChild(allCardElement);
   
   

    Album.forEach(album => {
        let albumElement = document.createElement('div');
        albumElement.classList.add("card");
        let albumTitleElement = document.createElement('h4');
        albumTitleElement.classList.add("albumTitle");
        albumTitleElement.innerText = album.title;
        albumTitleElement.addEventListener("click",()=> displaySingleAlbum(album));
        let albumArtistElement = document.createElement("p");
        albumArtistElement.classList.add("albumArtist");
        let albumImage =document.createElement('img')
        albumImage.classList.add('album-image')
        albumArtistElement.innerText = album.artist;
        let deleteButton = document.createElement("button")
        deleteButton.innerText = `Delete ${album.title}`;
        deleteButton.addEventListener('click', () => deleteAlbum(album))
        albumElement.appendChild(albumTitleElement);
        albumElement.appendChild(albumArtistElement);
        albumElement.appendChild(deleteButton);
        allCardElement.appendChild(albumElement);
        allCardElement.appendChild(albumImage);
    });

    const form = document.createElement("form")
    form.classList.add("new-album-form")
    const titleInput = document.createElement("input")
    titleInput.classList.add("new-album-title")
    titleInput.setAttribute("type", "text")
    titleInput.setAttribute("placeholder", "Title")
    const artistInput = document.createElement("input")
    artistInput.classList.add("new-artist-input")
    artistInput.setAttribute("type", "text")
    artistInput.setAttribute("placeholder", "artist")
    const ratingInput = document.createElement("input")
    ratingInput.classList.add("new-rating-input")
    ratingInput.setAttribute("type", "text")
    ratingInput.setAttribute("placeholder", "Rating (1 - 10)")
    const submitAlbum = document.createElement("button")
    submitAlbum.classList.add("submit-album")
    submitAlbum.innerText = "Add Album"
    form.appendChild(titleInput)
    form.appendChild(artistInput)
    form.appendChild(ratingInput)
    form.appendChild(submitAlbum)
    allCardElement.appendChild(form)

    submitAlbum.addEventListener('click', (clickEvent) => {
        clickEvent.preventDefault()
        clearChildren(mainAlbumElement)
        const albumjson = {"title": titleInput.value, "artist": artistInput.value, "rating": ratingInput.value}
        fetch("http://localhost:8080/api/albums", {
            method:'POST', 
            headers:{'Content-Type': 'application/json'},
            body:JSON.stringify(albumjson)
        })
        .then(response => response.json())
        .then(album => displayHomeView(album))
        .then(albumElement => mainAlbumElement.appendChild(albumElement))
        .catch(err => console.error(err));
    })

    

    return mainElement;
}
export{
    displayHomeView
}