function DataListLayout2({ dataList }) {
    return <ul>
        {
            dataList.map((list, index) =>
                <li key={index}>{list}</li>
            )
        }
    </ul>
}

export default DataListLayout2;