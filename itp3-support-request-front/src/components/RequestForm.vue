<script>
import { useVuelidate } from "@vuelidate/core";
import { required, maxLength, email } from "@vuelidate/validators";

export default {
  setup() {
    return {
      validator: useVuelidate({ $autoDirty: true }),
    };
  },
  data() {
    return {
      inputs: {
        email: null,
        subject: null,
        description: null,
      },
    };
  },
  validations() {
    return {
      inputs: {
        email: { required, email },
        subject: { required, maxLength: maxLength(100) },
        description: { required, maxLength: maxLength(1000) },
      },
    };
  },
  methods: {
    async submit() {
      const resp = await this.$http.post("/support-request", this.inputs);
      if (resp.status === 204) {
        Object.assign(this.inputs, this.$options.data().inputs);
        this.validator.$reset();
      } else {
        console.error(resp);
      }
    },
  },
};
// async get(endpoint) {
//     const url = `http://localhost:8080/${endpoint}`;
//     const response = await fetch(url);
//     const header = response.headers;
//     if (header.get("content-type") == "application/json") {
//         return await response.json();
//     }
//     return null;
// },
</script>

<template>
  <h1>Submit Form</h1>
  <form novalidate @submit.prevent="submit">
    <div>
      <label for="email" class="form-label">Email :</label>
      <br />
      <input
        type="email"
        class="form-control"
        :class="{ 'is-invalid': validator.inputs.email.$error }"
        id="email"
        name="email"
        v-model="inputs.email"
      />
      <span v-if="validator.inputs.email.$error">
        {{ validator.inputs.email.$errors[0].$message }}
      </span>
    </div>
    <br />
    <div>
      <label for="subject" class="form-label">Subject :</label>
      <br />
      <input
        type="text"
        class="form-control"
        :class="{ 'is-invalid': validator.inputs.subject.$error }"
        name="subject"
        id="subject"
        v-model="inputs.subject"
      />
      <span v-if="validator.inputs.subject.$error">
        {{ validator.inputs.subject.$errors[0].$message }}
      </span>
    </div>
    <br />
    <div>
      <label for="description" class="form-label">Description :</label>
      <br />
      <textarea
        class="form-control"
        :class="{ 'is-invalid': validator.inputs.description.$error }"
        id="description"
        name="description"
        rows="3"
        v-model="inputs.description"
      ></textarea>
      <span v-if="validator.inputs.description.$error">
        {{ validator.inputs.description.$errors[0].$message }}
      </span>
    </div>

    <div></div>
    <div>
      <button class="btn btn-primary" type="submit" id="buttonForm">
        Submit
      </button>
    </div>
  </form>
</template>
