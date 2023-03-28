document.querySelector(".topbtn").addEventListener("click", (e) => {
    e.preventDefault();
     window.scroll({
      top: 0,
      left: 0,
      behavior: "smooth"
    });
});

/*
    if(document.getElementById("updateMember")) {
        const $update = document.getElementById("updateMember");
        $update.onclick = function() {
            location.href = "/member/edit";
        }
    }
    
    
        if(document.getElementById("deleteMember")) {
        const $update = document.getElementById("deleteMember");
        $update.onclick = function() {
            location.href = "/member/delete/{id}";
        }
    }*/

