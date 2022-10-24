import './App.css';
import {Col, Container, Row} from "react-bootstrap";
import AdditionForm from "./components/AdditionForm";

function App() {
    return (
        <Container>
            <Row className="bg-dark w-100">
                <Col className="mx-auto w-100 text-center">
                    <h1 className="text-white">Calculatrice web</h1>
                </Col>
            </Row>
            <Row>
                <Col>
                    <AdditionForm />
                </Col>
            </Row>
        </Container>
    );
}

export default App;
