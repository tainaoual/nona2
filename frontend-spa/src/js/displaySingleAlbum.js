import{
    displayHomeView
} from "./displayHomeView.js"

const displaySingleAlbum = function (Album) {
    const mainAlbumElement = document.querySelector(".column-main")
    clearChildren(mainAlbumElement);
    const singleAlbumElement = document.createElement("div");
    singleAlbumElement.classList.add("single-album");
    mainAlbumElement.appendChild(singleAlbumElement);

    const albumCard = document.createElement('div');
    
    const albumNameElement = document.createElement("h4")
    albumNameElement.innerText = Album.title;
    albumNameElement.classList.add("albumTitle");
    
    const albumArtistElement = document.createElement("p");
    albumArtistElement.innerText = Album.artist;
    albumArtistElement.classList.add("albumArtist")
    
    const albumRatingElement = document.createElement("p")
    albumRatingElement.innerText = Album.rating;
    albumRatingElement.classList.add("albumRating")
   
    albumCard.appendChild(albumNameElement);
    albumCard.appendChild(albumArtistElement);
    albumCard.appendChild(albumRatingElement);
    singleAlbumElement.appendChild(albumCard);

    const songsRowElement = document.createElement("div");
    songsRowElement.classList.add("row","song-row");
    singleAlbumElement.appendChild(songsRowElement);

    Album.songs.forEach(song => {
        const songTitle = document.createElement("h4")
        songTitle.classList.add("songName");
        songTitle.innerText = song.title;
        songsRowElement.appendChild(songTitle);
    });
}

const clearChildren = function (element) {
    while(element.firstChild){
        element.removeChild(element.lastChild);
    }
}
    

export{
    displaySingleAlbum,
    clearChildren
}
/*    <div class="row song-row">
        <div class="image">
             <img class="play-song" src="./spec/Img/icons8-play-64.png" alt="Avatar">
         </div>
         <div class="song song-info">
             <!-- link to song name -->
             <h4><b>Song Name</b></h4>
             <!-- add runtime here -->
             <p>Duration</p>
         </div> */
//      </div>
            {/* <div class="single-album">
            <div class="album-card">
                <img class="single-album-image" src="./spec/Img/milkshake.PNG" alt="Avatar">
                <div class="album-info">
                    <!-- need to link to single album name -->
                    <h4><b>Album Name</b></h4>
                    <!-- need to link to artist name -->
                    <p>Artist Name</p>
                    <p>Rating:</p>
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                <label for="subject">Add a comment about your favorite song...</label>
                </div>
                <div class="col-75">
                <textarea id="subject" name="subject" placeholder="Write a comment.." style="height:200px"></textarea>
                </div>
            </div>
            </div> */}

