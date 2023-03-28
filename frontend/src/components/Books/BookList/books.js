import React from "react";
import BookTerm from "../BookTerm/bookTerm";
import {Link} from "react-router-dom";
const books = (props) => {
    return(
        <div className={"container mm-4 mt-5"}>
            <div className={"row"}>
                <div className={"row"}>
                    <table className={"table table-striped"}>
                        <thead>
                        <tr>
                            <th scope={"col"}>Name</th>
                            <th scope={"col"}>Category</th>
                            <th scope={"col"}>Author</th>
                            <th scope={"col"}>AvailableCopies</th>
                        </tr>
                        </thead>
                        <tbody>
                        {props.books.map((term)=>{
                            return(
                              <BookTerm term={term} onDelete={props.onDelete} onMark={props.onMark}/>
                            );
                        })}
                        </tbody>
                    </table>
                </div>
                <div className="col mb-3">
                    <div className="row">
                        <div className="col-sm-12 col-md-12">
                            <Link className={"btn btn-block btn-dark"} to={"/books/add"}>Add new book</Link>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    );
}
export default books;