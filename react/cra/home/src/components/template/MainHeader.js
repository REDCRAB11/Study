import {useContext} from 'react';
import ContextStore from 'react/cra/home/ContextStore.js';


const MainHeader = props => {
    //외부에 ContextStore라고 만든 저장소를 불러와서 사용하겠다
    //- useContext(저장소 객체)
    const store = useContext(ContextStore);
    return (
        <>
            <div>
                <h1>Header! {store.number}</h1>
            </div>
        </>
    );
};

export default MainHeader;