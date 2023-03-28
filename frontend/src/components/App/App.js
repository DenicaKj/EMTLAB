import './App.css';
import React, {Component} from "react";
import Books from "../Books/books";
import BookShopService from "../../repository/bookShopRepository";
import {BrowserRouter as Router, Redirect, Route} from "react-router-dom";
import Authors from "../Authors/authors";
import Categories from "../Categories/categories";

class App extends Component{
    constructor(props) {
        super(props);
        this.state = {
            books:[],
            authors:[],
            categories:[]
        }
    }
    render() {
        return(
            <Router>
                <main>
                    <div className={"container"}>
                        <Route path={"/books"} exact render={() => <Books books={this.state.books}/>}></Route>
                        <Route path={"/authors"} exact render={() => <Authors authors={this.state.authors}/>}></Route>
                        <Route path={"/categories"} exact render={() => <Categories categories={this.state.books}/>}></Route>
                    </div>
                </main>
            </Router>
        );
    }
    loadBooks = () =>{
        BookShopService.fetchBooks()
            .then((data)=>{
                this.setState({
                    books:data.data
                })
            });
    }
    componentDidMount() {
        this.loadBooks();
    }

}
export default App;
