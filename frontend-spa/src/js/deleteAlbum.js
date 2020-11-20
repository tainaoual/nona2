import {
    displayHomeView
}   from "./displayHomeView.js"

import {
    clearChildren
}   from "./displaySingleAlbum.js"

const deleteAlbum = function (album) {
    const mainAlbumElement = document.querySelector(".column-main")

    clearChildren(mainAlbumElement);
    fetch(`http://localhost:8080/api/albums/${album.id}`, {
        method:'DELETE'
    })
    .then(response => response.json())
    .then(album => displayHomeView(album))
    .then(albumElement => mainAlbumElement.appendChild(albumElement));

}

export {
    deleteAlbum
}