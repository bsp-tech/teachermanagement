let lists=document.querySelectorAll(".lists li")
let contents=document.querySelectorAll(".content")


lists.forEach(list=>{
    
    list.addEventListener("click",()=>{
        let acId=document.querySelector(".lists .active").dataset.id
        document.querySelectorAll(".content")[acId].classList.remove("d-block")
        document.querySelectorAll(".content")[acId].classList.add("d-none")
        document.querySelector(".lists .active").children[0].classList.remove("text-success","border","border-bottom-0")
        document.querySelector(".lists .active").children[0].classList.add("text-secondary","border-bottom")
        document.querySelector(".lists .active").classList.remove("active")
        

        list.children[0].classList.add("text-success","border","border-bottom-0")
        list.children[0].classList.remove("text-secondary","border-bottom")
        list.classList.add("active")

        let id=list.dataset.id
        document.querySelectorAll(".content")[id].classList.remove("d-none")
        document.querySelectorAll(".content")[id].classList.add("d-block")

        

    })
    
})