import React, {Component} from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom'

class List extends Component{

    state = {
        list:[], 
    }

    componentDidMount(){

        //=>는 함수를 만드는 또다른 방법!(생성을 좀 더 쉽게 한다)
        //var a = function(){};
        //var b = () => {};

        //axios 의 then은 callback함수
        axios.get('http://localhost:3001/list').then((value) => {
            //value 안쪽에 http 값들이 다 들어간다
            //그중에 필요한 것은 data 객체 안에 들어가있다
            this.setState({list:value.data.list});

        }).catch((error) =>{
            console.error(error);
        });
    }

    //리턴을 콜백으로 받을 것이므로 =>
    handleInsert = () => {

        //location.href = '/';
        this.props.history.push('/insert');

    }

    render(){
        return (
            <div>
                <table border = "1">
                    <tr>
                        <th>ID</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>시간</th>
                    </tr>
                    {this.renderList()}
                    <tr>
                        <td colSpan="4">
                            <input type = "button" value = "글작성"/>
                        </td>
                    </tr>
                    <input type = "button" value = "글작성" onClick = {this.handleInsert} />
                </table>
            </div>
        );
    }

    renderList(){
        var result = [];

        for(var i = 0; i < this.state.list.length; i++){
            result.push((
                <tr>
                    <td>{this.state.list[i].seq}</td>
                    <td><Link to = {'detail/' + this.state.list[i].seq}>{this.state.list[i].title}</Link></td>
                    <td>{this.state.list[i].name}</td>
                    <td>{this.state.list[i].date}</td>
                </tr>
            ));
        }

        return result;
    }

}


export default List;