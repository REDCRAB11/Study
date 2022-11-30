// 모듈 방식에서는 내보낸 요소만 사용이 가능하다. 
// 내보내는 방식은 2가지가 있다. 
// - 이름을 부여하여 내보내는 방식(export)
// - 기본값으로 내보내는 방식(export default)

const a = 10;
const b = 20;

const c = a+b;
// export {c}; //c를 외부에서 사용 가능하게 내보내라! 

// export const c = a+b; // 위랑 같음 

function hell(){
    console.log("go to hell");
}
// export{hell};

// export function hell(){
//     console.log("hell");
// }

//한번에 내보내기
export{c, hell};
