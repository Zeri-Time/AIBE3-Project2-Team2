package com.team2.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RqTest {

    @Test
    @DisplayName("write")
    void t1() {
        // given
        Rq rq = new Rq("write");

        // when
        String actionName = rq.getActionName();

        // then
        assertThat(actionName).isEqualTo("write");
    }

    @Test
    @DisplayName("list")
    void t2() {
        // given
        Rq rq = new Rq("list");

        // when
        String actionName = rq.getActionName();

        // then
        assertThat(actionName).isEqualTo("list");
    }

    @Test
    @DisplayName("detail 1")
    void t3() {
        // given
        Rq rq = new Rq("detail 1");

        // when
        String actionName = rq.getActionName();
        int id = rq.getParamAsInt("id", -1);

        // then
        assertThat(actionName).isEqualTo("detail");
        assertThat(id).isEqualTo(1);
    }

    @Test
    @DisplayName("update 1")
    void t4() {
        // given
        Rq rq = new Rq("update 1");

        // when
        String actionName = rq.getActionName();
        int id = rq.getParamAsInt("id", -1);

        // then
        assertThat(actionName).isEqualTo("update");
        assertThat(id).isEqualTo(1);
    }

    @Test
    @DisplayName("delete 1")
    void t5() {
        // given
        Rq rq = new Rq("delete 1");

        // when
        String actionName = rq.getActionName();
        int id = rq.getParamAsInt("id", -1);

        // then
        assertThat(actionName).isEqualTo("delete");
        assertThat(id).isEqualTo(1);
    }

    @Test
    @DisplayName("exit")
    void t6() {
        // given
        Rq rq = new Rq("exit");

        // when
        String actionName = rq.getActionName();

        // then
        assertThat(actionName).isEqualTo("exit");
    }
}