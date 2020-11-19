import{
    displaySingleAlbum,
    clearChildren
}from "./displaySingleAlbum.js"

const displayHomeView = function(Album){

    const mainElement = document.createElement("main");
    mainElement.classList.add("main")
    
    const columnMainElement = document.createElement("section");
    columnMainElement.classList.add("column-main")
    
    const allCardElement = document.createElement("div");
    allCardElement.classList.add("all-cards")
    
    const sectionElement = document.createElement("div")
    sectionElement.classList.add("card")

    mainElement.appendChild(columnMainElement);
    columnMainElement.appendChild(allCardElement);
    allCardElement.appendChild(sectionElement);
   

    Album.forEach(Album => {
        let albumElement = document.createElement('div');
        albumElement.classList.add("card");
        let albumTitleElement = document.createElement('h4');
        albumTitleElement.classList.add("albumTitle");
        albumTitleElement.innerText = Album.title;
        albumTitleElement.addEventListener("click",()=> displaySingleAlbum(album));
        let albumArtistElement = document.createElement("p");
        albumArtistElement.classList.add("albumArtist");
        let albumImage =document.createElement('img')
        albumImage.classList.add('album-image')
        albumArtistElement.innerText = Album.artist;
        albumElement.appendChild(albumTitleElement);
        albumElement.appendChild(albumArtistElement);
        sectionElement.appendChild(albumElement);
        sectionElement.appendChild(albumImage);

    });
    

    return mainElement;
}
export{
    displayHomeView
}