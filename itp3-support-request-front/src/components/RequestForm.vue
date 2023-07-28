<script>
import { useVuelidate } from '@vuelidate/core'
import { required, maxLength, email } from '@vuelidate/validators'


export default {
    setup() {
        const validator = useVuelidate();
        return {
            validator
        }
    },
    data() {
        return {
            inputs: {
                Email: null,
                Subject: null,
                Description: null
                
            },
            
        }
    },
    validations() {
        return {
            inputs: {
                Email: { required, email},
                Subject: { required, maxLength: maxLength(100) },
                Description: { required, maxLength: maxLength(1000) },
                
            }
        }
    },
    methods: {
        async submitForm() {
            const valid = await this.validator.$validate();
            const response = await this.send();
            if (valid) {
               console.log('submit form')
                if (response) {
                    Object.assign(this.$data.inputs, this.$options.data().inputs);
                    this.validator.$reset();
                }
            }
        },
        // async get(endpoint) {
        //     const url = `http://localhost:8080/${endpoint}`;
        //     const response = await fetch(url);
        //     const header = response.headers;
        //     if (header.get("content-type") == "application/json") {
        //         return await response.json();
        //     }
        //     return null;
        // },
        async send() {
            const url = "http://localhost:8080/stickers";
            const method = "POST";
            const data = this.inputs;
            const options = {
                method: method
            };
            options.body = JSON.stringify(data);
            options.headers = {
                'Content-Type': 'application/json'
            }
            const response = await fetch(url, options);
            if (response.status == 204) {
                return true;
            } else {
                return false;
            }
        }
    }
}
</script>

<template>

        <h1>Submit Form</h1>
        <form @submit.prevent="submitForm">
            <div>
                <label for="Email" class="form-label">Email :</label>
                <br>
                <input type="email" class="form-control" :class="{ 'is-invalid': validator.inputs.Email.$error }"
                    id="Email" name="Email" v-model="inputs.Email">
                <span v-if="validator.inputs.Email.$error">
                    {{ validator.inputs.Email.$errors[0].$message }}
                </span>
            </div>
            <br>
            <div>
                <label for="Subject" class="form-label">Subject :</label>
                <br>
                <input type="text" class="form-control" :class="{ 'is-invalid': validator.inputs.Subject.$error }"
                    name="Subject" id="Subject" v-model="inputs.Subject">
                <span v-if="validator.inputs.Subject.$error">
                    {{ validator.inputs.Subject.$errors[0].$message }}
                </span>
            </div>
            <br>
            <div>
                <label for="Description" class="form-label">Description :</label>
                <br>
                <textarea class="form-control" :class="{ 'is-invalid': validator.inputs.Description.$error }"
                    id="Description" name="Description" rows="3" v-model="inputs.Description"></textarea>
                <span v-if="validator.inputs.Description.$error">
                    {{ validator.inputs.Description.$errors[0].$message }}
                </span>
            </div>
           
            <div>
                
            </div>
            <div>
                <button class="btn btn-primary" type="submit"
                    id="buttonForm">Submit</button>
            </div>
        </form>
    
</template>