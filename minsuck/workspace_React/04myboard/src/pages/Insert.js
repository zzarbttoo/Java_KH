import React, {Component} from 'react';
import Axios from 'axios';

class Insert extends Component{

    //render 변수
    title = React.createRef();
    name = React.createRef();
    content = React.createRef();

    handleInsert = () =>{
        //값 가져오는 방법
        Axios.post('http://localhost:3001/insert', 
        //ref에 넣어준 member변수
        //this 사용하는 곳은 무조건 function 대신 => 사용
        {title:this.title.current.value, name:this.name.current.value, content:this.content.current.value}).then((value) => {
            if(value.data.success){
                alert('글 작성 성공');
                this.props.history.push('/');
            }else{
                alert('글 작성 실패');
            }
        });
        


    }

    //크롬의 뒤로가기와 같다
    handleHistoryBack = () =>{
        this.props.history.goBack();
        //this.props.history.push('/');
    }

    render(){

        return(

            <div>
                <h1>Insert</h1>

                <table border = "1">
                    <tr>
                        <th>제목</th>
                        <td><input type = "text" ref = {this.title}/></td>
                    </tr>
                    <tr>
                        <th>작성자</th>
                        <td><input type = "text" ref = {this.name}/></td>
                    </tr>
                    <tr>
                        <th>내용</th>
                        <td><textarea cols = "40" rows = "10" ref = {this.content}></textarea></td>
                    </tr>
                    <tr>
                        <td colSpan = "2" align = "right">
                            <input type = "button" value = "게시하기" onClick = {this.handleInsert}/>
                            <input type = "button" value = "돌아가기" onClick = {this.handleHistoryBack}/>
                        </td>
                    </tr>
                </table>
            </div>

        )
    }

}

export default Insert;
