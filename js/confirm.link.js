//목표 : .confirm-link라는 클래스를 가진 a태그를 누르면 확인창 출력 후 이동
window.addEventListener("load", function(){

    //모듈을 만들 때에는 개수를 알 수 없다고 생각하고 구현해야 한다.
    var linkList = document.querySelectorAll(".confirm-link");
    if(linkList.length == 0) return;

    for(var i=0; i < linkList.length; i++){
        linkList[i].addEventListener("click", function(e){
            var choice = window.confirm("정말 이동하시겠습니까?");
            if(choice == false){
                e.preventDefault();//기본 이벤트 차단 명령(이벤트 객체 사용)
                //return false;
            }
        });
    }

});