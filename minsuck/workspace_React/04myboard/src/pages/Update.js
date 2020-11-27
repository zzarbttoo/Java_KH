import React, {Component} from 'react';
import Axios from 'axios';

class Update extends Component{

    //render 변수
    title = React.createRef();
    name = React.createRef();
    content = React.createRef();

    componentDidMount(){
        Axios.get('http://localhost:3001/detail/' + this.props.match.params.seq).then((value) =>{
            this.title.current.value = value.data.data.title;
            this.name.current.value = value.data.data.name;
            this.content.current.value = value.data.data.content;
        });
    }

    handleUpdate = () =>{
        
        Axios.put('http://localhost:3001/update',
        {seq:this.props.match.params.seq,
        title : this.title.current.value,
        content:this.content.current.value}
        ).then((value) =>{
            if(value.data.success){
                alert('게시글 수정 성공!');
                this.props.history.push('/detail/' + this.props.match.params.seq);
            }else{
                alert('게시글 수정 실패!');
            }
        });

    }

    //크롬의 뒤로가기와 같다
    handleHistoryBack = () =>{
        this.props.history.goBack();
    }

    render(){

        return(

            <div>
                <h1>Update</h1>

                <table border = "1">
                    <tr>
                        <th>제목</th>
                        <td><input type = "text" ref = {this.title}/></td>
                    </tr>
                    <tr>
                        <th>작성자</th>
                        <td><input type = "text" ref = {this.name} readOnly/></td>
                    </tr>
                    <tr>
                        <th>내용</th>
                        <td><textarea cols = "40" rows = "10" ref = {this.content}></textarea></td>
                    </tr>
                    <tr>
                        <td colSpan = "2" align = "right">
                            <input type = "button" value = "수정하기" onClick = {this.handleUpdate}/>
                            <input type = "button" value = "돌아가기" onClick = {this.handleHistoryBack}/>
                        </td>
                    </tr>
                </table>
            </div>

        )
    }

}

export default Update;
