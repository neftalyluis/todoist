package mx.neftaly.todoist

import mx.neftaly.todoist.controller.TodoSetsController
import mx.neftaly.todoist.repository.TodoSetRepository
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders

import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

@AutoConfigureMockMvc
@WebMvcTest
class TodoSetsControllerSpec extends Specification {
    def todosetsController = new TodoSetsController()

    MockMvc mvc = MockMvcBuilders.standaloneSetup(todosetsController).build()

    def setup() {
        todosetsController.todoSetRepository = Mock(TodoSetRepository)
    }

    def "when get is performed then the response has status 200 and content is 'Hello world!'"() {
        expect: "Status is 200 and the response is 'Hello world!'"
        mvc.perform(MockMvcRequestBuilders.get("/todosets"))
                .andExpect(MockMvcResultMatchers.status().isOk())
    }
}
