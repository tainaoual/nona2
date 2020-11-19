import{
    displaySingleAlbum
}from "./displaySingleAlbum.js"

const displayHomeView = function(Albums){
    const mainElement = document.createElement("main");
    mainElement.classList.add("main")
    const columnMainElement =document.createElement("section");
    columnMainElement.classList.add("column-main")
    const allCardElement = document.createElement("div");
    allCardElement.classList.add("all-cards")
    const sectionElement = document.createElement("div")
    sectionElement.classList.add("card")
    mainElement.appendChild(columnMainElement);
    columnMainElement.appendChild(allCardElement);
    allCardElement.appendChild(sectionElement);

    let albumListHTML = "";

    Albums.forEach(Album => {
        let albumElement = document.createElement('div');
        albumElement.classList.add("card");
        let albumTitleElement = document.createElement('h4');
        albumTitleElement.classList.add("albumTitle");
        albumTitleElement.innerText = Album.title;
        albumTitleElement.addEventListener("click",()=> displaySingleAlbum(Album));
        let albumArtistElement = document.createElement("p");
        albumArtistElement.classList.add("albumArtist");
        albumArtistElement.innerText = Album.artist;


        // albumListHTML += `
        //     <div class="card">
        //         <img src="./spec/Img/John-Doe.jpg" alt="Avatar" style="width:100%">
        //         <div class="container">
        //             <h4 class="albumTitle"><b>${Album.title}</b></h4>
        //             <p class="albumArtist">${Album.artist}</p>
        //         </div>
        //     </div>
        // `
    });
    sectionElement.innerHTML = albumListHTML;

    return mainElement;
}
export{
    displayHomeView
}