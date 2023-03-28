import './App.css';
import React, {Component} from "react";
import Books from "../Books/BookList/books";
import BookShopService from "../../repository/bookShopRepository";
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import {Navigate} from 'react-router-dom';
import Authors from "../Authors/authors";
import Categories from "../Categories/categories";
import Header from "../Header/header";
import BookAdd from "../Books/BookAdd/bookAdd";
import BookEdit from "../Books/BookEdit/bookEdit";

class App extends Component{
    constructor(props) {
        super(props);
        this.state = {
            books:[],
            authors:[],
            categories:[],
            selectedBook:{}
        }
    }
    render() {
        return(
            <Router>
                <Header/>
                <main>
                    <div className={"container"}>

                        <Routes>
                            <Route path={"/books/edit/:id"} element={<BookEdit authors={this.state.authors} categories={this.state.categories} onEditBook={this.editBook} book={this.state.selectedBook}/>}/>
                            <Route path={"/books/add"} element={<BookAdd authors={this.state.authors} categories={this.state.categories} onAddBook={this.addBook}/>}/>
                            <Route path={"/books"} element={<Books books={this.state.books} onDelete={this.deleteBook} onMark={this.markBook} onEdit={this.getBook}/>}/>
                            <Route path={"/authors"} element={<Authors authors={this.state.authors}/>}/>
                            <Route path={"/categories"} element={<Categories categories={this.state.categories} />}/>
                            <Route path={"/"} element={<Books books={this.state.books}/>}/>
                        </Routes>

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
    loadAuthors = () =>{
        BookShopService.fetchAuthors()
            .then((data)=>{
                this.setState({
                    authors:data.data
                })
            });
    }
    loadCategories = () =>{
        BookShopService.fetchCategories()
            .then((data)=>{
                this.setState({
                    categories:data.data
                })
            });
    }
    deleteBook = (id) =>{
        BookShopService.deleteBook(id)
            .then(()=>{
                this.loadBooks();
            });
    }
    markBook = (id) =>{
        BookShopService.markBook(id)
            .then(()=>{
                this.loadBooks();
            });
    }
    addBook = (name,category,author,availableCopies) =>{
        BookShopService.addBook(name,category,author,availableCopies)
            .then(()=>{
                this.loadBooks();
            });
    }
    getBook = (id) =>{
        BookShopService.getBook(id)
            .then((data)=>{
                this.setState({
                    selectedBook:data.data
                })
            });
    }
    editBook = (id,name,category,author,availableCopies) =>{
        BookShopService.editBook(id,name,category,author,availableCopies)
            .then(()=>{
                this.loadBooks();
            });
    }
    componentDidMount() {
        this.loadBooks();
        this.loadAuthors();
        this.loadCategories();
    }

}
export default App;
