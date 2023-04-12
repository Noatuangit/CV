import React, { Component } from 'react'
import Card from 'react-bootstrap/Card';

export default class Test extends Component {
    constructor() {
        super();
        this.state = {
            data: [{
                "id": "1",
                "name": "Bai tap 1",
                "description": "Mo ta bai tap 1",
                "image": "mon_256.png",
                "productImage": "ability_change_formation_spacing.png",
            },
            {
                "id": "2",
                "name": "Bai tap 3",
                "description": "Mo ta bai tap 2",
                "image": "mon_256 (6).png",
                "productImage": "ability_defend.png",
            },
            {
                "id": "3",
                "name": "Bai tap 4",
                "description": "Mo ta bai tap 3",
                "image": "mon_256 (2).png",
                "productImage": "ability_delpoyables_bamboo_wall.png",
            }
                ,
            {
                "id": "4",
                "name": "Bai tap 5",
                "description": "Mo ta bai tap 5",
                "image": "mon_256 (3).png",
                "productImage": "ability_dismount.png",
            }]
        }

    }
    render() {
        return (
            <div>
                <h1>Product List</h1>
                <hr />
                <div className='item-card' style={{ display: 'flex' }}>
                    <hr />
                    {this.state.data.map(x =>
                        <div className='card mb-3 mx-auto' key={x.id}>
                            <Card style={{ width: '18rem' }}>
                                <Card.Img variant="top" src={require(`../../image/${x.image}`)} />
                                <Card.Body>
                                    <Card.Title>Card {x.name}</Card.Title>
                                    <Card.Text>
                                        id: {x.id};
                                        name: {x.name};
                                        description: {x.description};
                                        <br />
                                        Submit by:
                                        <img src={require(`../../image/${x.productImage}`)} />
                                    </Card.Text>
                                </Card.Body>
                            </Card>
                        </div>
                    )}
                </div>
            </div>
        )
    }
}
