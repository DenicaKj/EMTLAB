import React from "react";

const bookTerm = (props) =>{
    return(
        <tr>
            <td scope={"col"}>{props.term.name}</td>
            <td scope={"col"}>{props.term.category}</td>
            <td scope={"col"}>{props.term.author.name}</td>
            <td scope={"col"}>{props.term.availableCopies}</td>
            <td className={"text-right"}>
                <a title={"Delete"} className={"btn btn-danger"}
                   onClick={() => props.onDelete(props.term.id)}>Delete</a>
            </td>
            <td className={"text-center"}>
                <a title={"Mark"} className={"btn btn-info"}
                   onClick={() => props.onMark(props.term.id)}>Mark As Taken</a>
            </td>
        </tr>
    );

}
export default bookTerm;