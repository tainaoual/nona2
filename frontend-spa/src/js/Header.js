const createHeader = function(){
    const header = document.createElement("div")
    header.classList.add("top-header") 
    header.innerHTML ='<section class="header"><h1>jukeboxe soda shoppe</h1></section><section class="topnav"><a href="#">Link</a><a href="#">Link</a><a href="#">Link</a></section><section class="row"></section>'

    return header;
}

export {
    createHeader
}