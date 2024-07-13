export default {
    props: {
        labelUsername: String,
        labelPassword: String,
        buttonLogin: String
    },
    data() {
        return {
            // パスワード表示・非表示
            isReveal: false
        }
    },
    methods: {
        // パスワード表示・非表示
        switchReveal() {
            this.isReveal = !this.isReveal
        }
    },
    template: `
        <div class="uk-margin uk-child-width-expand">
            <label for="username" class="uk-form-label">{{ labelUsername }}</label>
            <div class="uk-form-controls uk-inline">
                <span class="uk-form-icon" uk-icon="icon: user"></span>
                <input type="text" id="username" name="username" class="uk-input" />
            </div>
        </div>
        <div class="uk-margin uk-child-width-expand">
            <label for="password" class="uk-form-label">{{ labelPassword }}</label>
            <div class="uk-form-controls uk-inline">
                <span class="uk-form-icon" uk-icon="icon: lock"></span>
                <input :type="isReveal ? 'text' : 'password'" id="password" name="password"
                    class="uk-input" />
                <button type="button" class="uk-form-icon uk-form-icon-flip"
                    :uk-icon="isReveal ? 'icon: eye-slash' : 'icon: eye'" @click="switchReveal"></button>
            </div>
        </div>
        <div class="uk-margin uk-child-width-expand">
            <div uk-form-custom>
                <button type="submit" class="uk-button uk-button-primary uk-align-right">
                    <span uk-icon="icon: sign-in"></span>
                    <span>{{ buttonLogin }}</span>
                </button>
            </div>
        </div>
    `
}