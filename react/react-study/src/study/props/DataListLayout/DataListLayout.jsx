function DataListLayout({ children }) {

    console.log(children)
    const liList = [
        <li>5번리스트</li>,
        <li>6리스트</li>,
        <li>7번리스트</li>,
        <li>8번리스트</li>,
    ];

    children.map(li => <li>{"1" + li.props.children}</li>)

    return <ul>
        {children}
        {liList}
        {
            children.map((li, index) => 
                <li key={index}>{"1" + li.props.children}</li>
            )
        }
        {
            liList.map((list, index) =>
                <li key={index}>{"2" + list.props.children}</li>
            )
        }
    </ul>
}

export default DataListLayout;