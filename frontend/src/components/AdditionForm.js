import {useState} from "react"
import {Button, Form} from "react-bootstrap";

const AdditionForm = () => {
    const [firstSelectedNumber, setFirstSelectedNumber] = useState("")
    const [secondSelectedNumber, setSecondSelectedNumber] = useState("")
    const [result, setResult] = useState("")

    const onSubmit = async (event) => {
        event.preventDefault();

        try {
            const response = await fetch("http://localhost:8080/add", {
                method: "PUT",
                headers: {'Content-Type': 'application/json'},
                body: JSON.stringify(
                    {firstNumber: firstSelectedNumber, secondNumber: secondSelectedNumber})
            })

            if (response.ok) {
                const data = await response.json();
                setResult(data.result);
            } else {
                alert("Une erreur est survenue!")
            }
        } catch (exception) {
            console.log(exception)
            alert("Une erreur est survenue!")
        }
    }


    return (
        <Form onSubmit={event => onSubmit(event)}>
            <Form.Group>
                <Form.Label>One</Form.Label>
                <Form.Control placeholder="One" type="number" value={firstSelectedNumber}
                              onChange={event => setFirstSelectedNumber(event.target.value)}/>
            </Form.Group>
            <Form.Group>
                <Form.Label>Two</Form.Label>
                <Form.Control placeholder="Two" type="number" value={secondSelectedNumber}
                              onChange={event => setSecondSelectedNumber(event.target.value)}/>
            </Form.Group>
            <Button type="submit" className="mt-3">Additionne</Button>
            <h2 className="text-center">{result}</h2>
        </Form>
    );
}

export default AdditionForm;