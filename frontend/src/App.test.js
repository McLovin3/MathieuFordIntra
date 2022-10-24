import App from './App';
import {act} from "react-dom/test-utils";
import {fireEvent, render, screen} from '@testing-library/react';

describe("AppTest", () => {
    let numberOne;
    let numberTwo;

    beforeEach(async () => {
        numberOne = 10;
        numberTwo = 10;

        global.fetch = jest.fn((url) => {
            if (url === "http://localhost:8080/add") {
                return Promise.resolve({
                    ok: true,
                    json: () => Promise.resolve({result: numberOne + numberTwo})
                });
            } else return new Error("Bad url call")
        });

        await act(async () => {
            render(<App/>);
        })
    })

    it("HeaderIsPresentTest", async () => {
        expect(await screen.findByText(/Calculatrice web/i)).toBeInTheDocument();
    });

    it("AddTest", async () => {
        const firstNumberInput = await screen.findByPlaceholderText(/one/i);
        const secondNumberInput = await screen.findByPlaceholderText(/two/i);
        const addButton = await screen.findByRole("button", {name: /additionne/i})

        await act(async () => {
            fireEvent.change(firstNumberInput, {target: {value: numberOne}})
            fireEvent.change(secondNumberInput, {target: {value: numberTwo}})
            fireEvent.click(addButton);
        })

        expect(await screen.findByText(numberOne + numberTwo)).toBeInTheDocument();
        expect(fetch).toBeCalledTimes(1);
    });
});
