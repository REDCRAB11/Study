//Context API를 사용하여 컴포넌트에서 모두 접근 및 변경이 가능한 저장소를 구현 
// - react에 내장된 createContext라는 함수로 저장소를 생성 
import {createContext} from 'react';
import ContextStroe from './ContextStore';
import { useState } from 'react';

const ContextStroe = createContext(null);

export default ContextStroe;

// - 기본 제공되는 ContextStroe의 Provider로는 읽기만 가능
// - 개조해서 Custom Provider를 만든 다음 state를 추가하여 데이터 변화를 관리 
const ContextCustomProvider = props=>{
    
    const [number, setNumber] = useState(123);
    // - 함수형 컴포넌트는 무조건 JSX를 반환해야 한다. 
    // - 원래 작성된 ContextStore.Provider와 내부 정보를 JSX로 반환하도록 설정 
    // - state를 추가하고 value로 내보내서 전체에서 사용 가능하도록 구현 
    return(
        <ContextStroe.Provider value={{number:100}}>
            {/* 원래 providerdml soqnxorm wjdqh */}
                {props.children}
        </ContextStroe.Provider>
    );
};