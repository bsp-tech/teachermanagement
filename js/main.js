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
// profile
let profileLists=document.querySelectorAll(".profile-list")
let profileContents=document.querySelectorAll(".profile-content")


    
profileLists.forEach(list=>{
    list.addEventListener("click",()=>{
        if(list.dataset.id===6) {

        }
        else {
            let acID=document.querySelector(".profile-lists .active").dataset.id
            document.querySelectorAll(".profile-content")[acID].classList.remove('d-block')
            document.querySelectorAll(".profile-content")[acID].classList.add('d-none')
            document.querySelectorAll(".profile-content")[acID].classList.remove('active')
            document.querySelector(".profile-lists .active").classList.remove("border-success")
            document.querySelector(".profile-lists .active").children[0].children[0].classList.remove("text-success")
            document.querySelector(".profile-lists .active").children[0].children[1].classList.remove("text-success")
            document.querySelector(".profile-lists .active").children[0].children[0].classList.add("text-muted")
            document.querySelector(".profile-lists .active").children[0].children[1].classList.add("text-muted")
            document.querySelector(".profile-lists .active").classList.remove("active")
            list.classList.add("active")
            list.classList.add("border-success")
            list.classList.remove("border-muted")
            list.children[0].children[0].classList.add("text-success")
            list.children[0].children[1].classList.add("text-success")
            list.children[0].children[0].classList.remove("text-muted")
            list.children[0].children[1].classList.remove("text-muted")
            let id=list.dataset.id
            document.querySelectorAll(".profile-content")[id].classList.add('d-block')
            document.querySelectorAll(".profile-content")[id].classList.remove('d-none')
            document.querySelectorAll(".profile-content")[id].classList.add('active')
        }
       

        
    })
})