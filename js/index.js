// Section-7 Collapse---------------------------------------------------------
let plus = document.querySelectorAll('h6 .collapsed');
let show = document.querySelectorAll('#accordion .collapse');
console.log(show);

let k = 5 , num = 0;
for(let i = 0;i<plus.length;i++){
    plus[i].onclick = function(){
        for(let j =0;j<show.length;j++){
            plus[j].firstElementChild.classList.add("fa-plus-square");
        }
        plus[i].firstElementChild.classList.remove("fa-plus-square");
        plus[i].firstElementChild.classList.add("fa-minus-square");
        if(i === k){
            if(num%2===0){
            plus[i].firstElementChild.classList.add("fa-plus-square");
        }
            num++;
        }
        else num = 0;
        console.log(i + "  " + k);
        k = i;
    }
}
//-------------------------------------------------------------------------------