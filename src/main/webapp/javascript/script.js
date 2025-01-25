function showMobileMenu(){
    const menuBtn = document.getElementById("menu-btn");
    const mobileMenu = document.getElementById("mobile-menu");
    const isHidden = mobileMenu.classList.contains("opacity-0");

    if(isHidden){
        mobileMenu.classList.remove("opacity-0","max-h-0");
        mobileMenu.classList.add("opacity-100","max-h-100");
    }else{
        mobileMenu.classList.remove("opacity-100","max-h-100");
        mobileMenu.classList.add("opacity-0","max-h-0");
    }
}