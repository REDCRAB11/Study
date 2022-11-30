import {useState} from 'react'; 
import axios from '../../AxiosManeger';
//로그인 페이지
//- id/pw 입력창, 로그인 버튼 필요
//- 로그인 버튼 클릭 시, 비동기 통신으로 서버에 id, pw 전송

const LoginPage = props=>{
    //회원 정보 state
    const [member, setMember] = useState({
        memberId:'',
        memberPw:''
    });
    
    //객체 업데이트 함수
    const changeMemberInfo = e=>{
        const name = e.target.name;
        const value = e.target.value;

        setMember({
            ...member,
            [name]:value
        });
    };

    //로그인 함수  - axios를 통해 서버의 로그인 컨트롤러에 member 정보를 전송 
    const sendLoginInfo = e=>{
      axios({
        url:"http://localhost:8888/member/login",
        method:"post",
        // responseType:"json" 제이슨으로 가서 쓰나마나 해 
        data:member
      }).then(resp=>{
        console.log("성공",resp);
      }).catch(e=>{
        console.log("실패",e);
      }).finally(()=>{});
    };

    return(
        <>
            <div>
                <h1>Login</h1>
                <input type="text" name="memberId" placeholder="아이디" onChange={changeMemberInfo}></input>
                <br/><br/>
                <input type="password" name="memberPw" placeholder="비밀번호" onChange={changeMemberInfo}></input>
                <br/><br/><br/><br/>
                <button onClick={sendLoginInfo}>로그인</button>
            </div>
        </>
    );
};

export default LoginPage;