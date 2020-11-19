const displayHomeView = function(Albums){
    const mainElement = document.createElement("main");
    mainElement.classList.add("main")
    const sectionElement = document.createElement("div")
    sectionElement.classList.add("card")
    mainElement.appendChild(sectionElement);

    let albumListHTML = "";

    Albums.forEach(Album => {
        albumListHTML += `
            <div class="card">
                <img src="./spec/Img/John-Doe.jpg" alt="Avatar" style="width:100%">
                <div class="container">
                    <h4><b>${Album.title}</b></h4>
                    <p>${Album.artist}</p>
                </div>
            </div>
        `
    });
    sectionElement.innerHTML = albumListHTML;

    return mainElement;
}
export{
    displayHomeView
}