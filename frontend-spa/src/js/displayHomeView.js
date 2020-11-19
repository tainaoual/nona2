import{
    displaySingleAlbum,
    clearChildren
}from "./displaySingleAlbum.js"

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
        albumElement.appendChild(albumTitleElement);
        albumElement.appendChild(albumArtistElement);
        allCardElement.appendChild(albumElement);
        allCardElement.appendChild(albumImage);

    });
    

    return mainElement;
}
export{
    displayHomeView
}