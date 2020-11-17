const createSection = function(){
    const section = document.createElement("section")
    header.classList.add("header") 
    header.innerHTML = '<h1>jukeboxe soda shoppe</h1>'

    return section;
}

export {
    createSection
}