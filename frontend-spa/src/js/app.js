import {createHeader
} from "./Header.js";
import {
    allAlbums
} from "./sampleAlbumJSON.js";
import{displayHomeView
} from "./displayHomeView.js"
document.querySelector('.top-header').prepend(createHeader());
document.querySelector('.main').appendChild(displayHomeView(allAlbums))

