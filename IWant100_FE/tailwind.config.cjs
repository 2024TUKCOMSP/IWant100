module.exports = {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      colors: {
        primary: {
          900: '#E8ECFA',
          800: '#F00E00',
          700: '#008FF6',
          600: '#D4E1FA',
          500: '#CCEAFF',
        },
        secondary: {
          900: '#999999',
        }
      },
      fontFamily: {
        esamanru: ['GongGothicMedium'],
      },
      backgroundImage: {
        'add-icon': "url('/icons/add.svg')",
        'back-arrow-icon': "url('/icons/back-arrow.svg')",
        'delete-icon': "url('/icons/delete.svg')",
        'drop-down-icon': "url('/icons/drop-down.svg')",
        'google-icon': "url('/icons/Google-removebg-preview.svg')",
        'login-lock-icon': "url('/icons/login-lock.svg')",
        'select-option-icon': "url('/icons/select-option.svg')",
        'submit-icon': "url('/icons/submit.svg')",
      },
      boxShadow: {
        'default': '0 4px 4px rgba(0, 0, 0, 0.25)',
        'login-button': 'rgba(17, 17, 26, 0.1) 0px 1px 0px, rgba(17, 17, 26, 0.1) 0px 8px 24px, rgba(17, 17, 26, 0.1) 0px 16px 48px',
      },
    },
    screens: {
      xs: '405px',
      sm: '470px',
    },
  },
  plugins: [
    function ({ addUtilities }) {
      const newUtilities = {
        '.border-radius-custom': {
          'border-radius': '0% 100% 0% 100% / 28% 0% 100% 72%',
        },
      }
      addUtilities(newUtilities, ['responsive', 'hover'])
    },
  ],
}