function About(props){
    // class 형 컴포넌트다
    // this.props.match.params.이름
    return (<div><h1>About {props.match.params.name}</h1></div>);
}

//component를 만들어서 export 해줘야한다
export default About;