import React, {Component} from 'react';
import Axios from 'axios';

class Detail extends Component{

    //값을 받아와서 저장
    state = {
        myboard:false,

    };

    componentDidMount(){
        Axios.get('http://localhost:3001/detail/' + this.props.match.params.seq).then((value) =>{
            this.setState({myboard:value.data.data});
        });
    }

    handleList = () => {
        //돌아가기
        //goBack(); - 수정 들어갔다 나오면 다시 수정으로 돌아가게됨
        this.props.history.push('/');
    }

    handleUpdate = () => {
        //수정
        this.props.history.push('/update/' + this.props.match.params.seq);
    }

    handleDelete = () => {
        //삭제
        if(this.state.myboard){
            //Axios의 delte는 get방식 밖에 안됨
            Axios.delete('http://localhost:3001/delete/' + this.state.myboard.seq).then((value) =>{
                if(value.data.success){
                    alert('게시글 삭제');
                    this.props.history.push('/');
                }else{
                    alert('게시글 삭제 실패!');
                }
            });

        }
    }

    render(){
        return(
            <div>
                <h1>Detail</h1>
                <table border = "1">
                    <tr>
                        <th>제목</th>
                        <td>{this.state.myboard ? this.state.myboard.title : ''}</td>
                    </tr>
                    <tr>
                        <th>작성자</th>
                        <td>{this.state.myboard ? this.state.myboard.name : ''} </td>
                    </tr>
                    <tr>
                        <th>내용</th>
                        <td>
                            <textarea cols = "40" rows = "10"  value = {this.state.myboard ? this.state.myboard.content : ''} readOnly>
                            </textarea>
                       </td>
                    </tr>
                    <tr>
                        <td colSpan = "2">
                            <input type = "button" value = "목록" onClick={this.handleList}/>
                            <input type = "button" value = "수정" onClick={this.handleUpdate} />
                            <input type = "button" value = "삭제" onClick={this.handleDelete}/>
                        </td>
                    </tr>   
                </table>
            </div>

        );
    }

}

export default Detail;