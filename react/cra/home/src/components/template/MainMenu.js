import {Link}  from 'react-router-dom';
const MainMenu = props => {
    return (
        <>
            <div>
               <h1>
                {/* router에 대한 이동 링크는 Link 태그로 작성한다. */}
                <Link to ='/'>HOME</Link><br/>
                <Link to ='/login'>Login</Link><br/>
                <Link to ='/board/list'>BOARD</Link>
               </h1>
            </div>
        </>
    );
};

export default MainMenu;