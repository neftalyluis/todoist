package mx.neftaly.todoist

import com.fasterxml.jackson.databind.ObjectMapper
import mx.neftaly.todoist.controller.TodoSetsController
import mx.neftaly.todoist.model.TodoSet
import mx.neftaly.todoist.services.TodoSetService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType
import spock.mock.DetachedMockFactory
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static groovy.json.JsonOutput.toJson

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

@WebMvcTest(controllers = [TodoSetsController])
class TodoSetsControllerSpec extends Specification {

    @Autowired
    TodoSetService todoSetService

    @Autowired
    protected MockMvc mvc

    @Autowired
    ObjectMapper objectMapper

    def "Getting all todosets"() {
        given: "a list of todosets"
        todoSetService.showAll() >> [new TodoSet(name: 'Todos', description: 'Lol')]

        when: "calling the endpoint"
        def results = mvc.perform(get('/todosets'))

        then: "there is a todo set"
        results.andExpect(status().isOk())

        and:
        def jsonResponse = results.andReturn().response.contentAsString

        and:
        with(objectMapper.readValue(jsonResponse, List)) {
            it[0].name == 'Todos'
            it[0].description == 'Lol'
        }
    }

    def "Showing one todoset"() {
        given: "a list of todosets"
        todoSetService.find(id) >> Optional.of(new TodoSet(name: 'Todos', description: 'Lol'))

        when: "calling the endpoint"
        def results = mvc.perform(get("/todosets/${id}"))

        then: "there is a todo set"
        results.andExpect(status().isOk())

        and:
        def jsonResponse = results.andReturn().response.contentAsString

        and:
        with(objectMapper.readValue(jsonResponse, TodoSet)) {
            it.name == 'Todos'
            it.description == 'Lol'
        }

        where:
        id = 1
    }

    def "Creating a todoset"() {
        given: "a list of todosets"
        Map request = [
                name       : "memes",
                description: "memes"
        ]

        todoSetService.create(_) >> Optional.of(new TodoSet(name: 'Todos', description: 'Lol'))

        when: "calling the endpoint"
        def results = mvc.perform(
                post("/todosets/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(request))
        )

        then: "there is a todo set"
        results.andExpect(status().isOk())

        and:
        def jsonResponse = results.andReturn().response.contentAsString

        and:
        with(objectMapper.readValue(jsonResponse, TodoSet)) {
            it.name == 'Todos'
            it.description == 'Lol'
        }
    }

    @TestConfiguration
    static class StubConfig {
        DetachedMockFactory detachedMockFactory = new DetachedMockFactory()

        @Bean
        TodoSetService todoSetService() {
            return detachedMockFactory.Stub(TodoSetService)
        }
    }
}
