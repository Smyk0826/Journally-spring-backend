
import React, { useState } from 'react';

function ListItem({data, date }) {
  const [expanded, setExpanded] = useState(false);

  const toggleCard = () => {
    setExpanded(!expanded);
  };

  return (
    <div className={`card ${expanded ? 'expanded' : ''}`}>
      <h5 style={{ color: 'rgba(226, 161, 64, 0.61)'}}><b>{date}</b></h5>
      <p>{expanded ? data : `${data.slice(0, 50)}...`}</p>
      <button onClick={(e) => { e.stopPropagation(); toggleCard(); }}>
        {expanded ? 'Show Less' : 'Read More'}
      </button>
    </div>
  );
}


export default ListItem;