<template>
  <div>
    <h1>Add Avatar</h1>
    <form @submit.prevent="submitForm">
      <div>
        <input
          class="form-control form-control-lg"
          id="formFileLg"
          type="file"
          accept=".jpg, .gif, .png"
          ref="fileInput"
          @change="handleFileChange"
        />
        <div>
        <label for="formFileLg" class="form-label">Choose between: JPG, PNG, GIF (Max file size: 1MB)</label>
      </div>
      </div>
      <button type="submit" class="btn btn-primary btn-lg">Upload</button>
    </form>
  </div>
</template>

<script>
export default {
  methods: {
    handleFileChange(event) {
      const file = event.target.files[0];
      if (file) {
      
        const allowedTypes = ["image/jpeg", "image/png", "image/gif"];
        if (!allowedTypes.includes(file.type)) {
          alert("Please choose a valid file type: JPG, PNG, GIF.");
          this.$refs.fileInput.value = ""; // Clear the input field
          return;
        }

        const maxSize = 1024 * 1024; // 1MB
        if (file.size > maxSize) {
          alert("File size exceeds 1MB limit.");
          this.$refs.fileInput.value = ""; 
          return;
        }
        console.log('File not suportted')
      }
      this.selectedFile = file;
    },
    submitForm() {
      if (!this.selectedFile) {
        alert("Please select a file before submitting.");
        return;
      }

      alert("File submitted successfully!");
      
     
      this.$refs.fileInput.value = "";
      this.selectedFile = null;
      console.log('File Submitted')
    },
  },
  data() {
    return {
      selectedFile: null,
    };
  },
};
</script>
