import{
    displayHomeView
} from "./displayHomeView.js"

const displaySingleAlbum = function (Album) {
    const mainAlbumElement = document.querySelector("")
    clearChildren(mainAlbumElement);
    const singleAlbumElement = document.createElement("div");
    singleAlbumElement.classList.add("single-album");
    mainAlbumElement.appendChild(singleAlbumElement);
}
export{
    displaySingleAlbum,
    // clearChildren
}