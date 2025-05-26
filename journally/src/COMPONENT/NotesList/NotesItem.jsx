import React from "react";

function ListItem(props){
    return(
        <div className="NotesItem">
            <h2 className="dateItem">{props.date}</h2>
            <h3 className="dataItem">{props.title}</h3>
        </div>
    );
}

export default ListItem;